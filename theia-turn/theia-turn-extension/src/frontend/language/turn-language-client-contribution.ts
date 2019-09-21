/*
 * Copyright (C) 2017 TypeFox and others.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0
 */

import { inject, injectable, named } from 'inversify'
import { FrontendApplication, KeybindingRegistry, OpenerService, AbstractViewContribution, Widget } from '@theia/core/lib/browser'
import { ApplicationShell, Navigatable } from '@theia/core/lib/browser'
import URI from '@theia/core/lib/common/uri'
import {
    BaseLanguageClientContribution,
    LanguageClientFactory,
    Languages,
    Workspace,
    ILanguageClient
} from '@theia/languages/lib/browser'
import { MessageConnection } from 'vscode-jsonrpc';


import { SemanticHighlightingService } from '@theia/editor/lib/browser/semantic-highlight/semantic-highlighting-service';
import { DiagramManagerProvider, DiagramManager, DiagramManagerImpl } from 'theia-sprotty/lib'
import { CommandRegistry, Disposable, MenuPath, MenuModelRegistry, MenuContribution, CommandContribution, CommandHandler } from '@theia/core/lib/common'
import { ContextMenuCommands } from './dynamic-commands'
import { MessageService } from '@theia/core/lib/common'
import { EditorManager } from "@theia/editor/lib/browser"
import { OutlineViewWidget } from '@theia/outline-view/lib/browser/outline-view-widget';
import { MonacoOutlineSymbolInformationNode } from '@theia/monaco/lib/browser/monaco-outline-contribution';
export const OUTLINE_CONTEXT_MENU: MenuPath = ['outline-context-menu'];

export namespace OutlineContextMenu {
    export const OPEN = [...OUTLINE_CONTEXT_MENU, '1_open'];
    export const OPEN_WITH = [...OPEN, 'open_with'];
}

export const TURNDiagramCommand = {
    id: 'TURNDiagram.command',
    label: "Shows a message",
}

export const TURNStrategyCommand = {
    id: 'TURNStrategy.command',
    label: "Shows a message",
}

export const OUTLINE_WIDGET_FACTORY_ID = 'outline-view';

@injectable()
export class TurnLanguageClientContribution extends BaseLanguageClientContribution {

    readonly id = 'turn'
    readonly name = 'Turn'

    constructor(
        @inject(Workspace) workspace: Workspace,
        @inject(Languages) languages: Languages,
        @inject(LanguageClientFactory) languageClientFactory: LanguageClientFactory,
        @inject(DiagramManagerProvider) @named('turn-diagram') protected turnDiagramManagerProvider: DiagramManagerProvider,
        @inject(KeybindingRegistry) protected keybindingRegistry: KeybindingRegistry,
        @inject(CommandRegistry) protected commandRegistry: CommandRegistry,
        @inject(ContextMenuCommands) protected commands: ContextMenuCommands,
        @inject(SemanticHighlightingService) protected readonly semanticHighlightingService: SemanticHighlightingService
    ) {
        super(workspace, languages, languageClientFactory)
    }

    protected get globPatterns() {
        return [
            '**/*.turn'
        ]
    }

    waitForActivation(app: FrontendApplication): Promise<any> {
        return Promise.race([
            super.waitForActivation(app),
            this.waitForOpenDiagrams(this.turnDiagramManagerProvider())
        ])
    }

    createLanguageClient(connection: MessageConnection): ILanguageClient {
        const client: ILanguageClient & Readonly<{ languageId: string }> = Object.assign(super.createLanguageClient(connection), { languageId: this.id });
        client.registerFeature(SemanticHighlightingService.createNewFeature(this.semanticHighlightingService, client));
        return client;
    }

    protected waitForOpenDiagrams(diagramManagerProvider: Promise<DiagramManager>): Promise<any> {
        return diagramManagerProvider.then(diagramManager => {
            return new Promise<URI>((resolve) => {
                const disposable = diagramManager.onDiagramOpened((uri: URI) => {
                    disposable.dispose()
                    resolve(uri)
                })
            })
        })
    }

    registerCommand(id: string, callback: (...args: any[]) => any, thisArg?: any): Disposable {
        return this.commands.registerCommand(id, callback, thisArg)
    }
}

@injectable()
export class DiagramMenuContribution implements MenuContribution {
    registerMenus(registry: MenuModelRegistry): void {
        registry.registerMenuAction(OutlineContextMenu.OPEN, {
            commandId: TURNDiagramCommand.id,
            label: 'Generate Diagram'
        });
        registry.registerMenuAction(OutlineContextMenu.OPEN, {
            commandId: TURNStrategyCommand.id,
            label: 'Generate Diagram with Strategy'
        });
    }
}

@injectable()
export class OpenInDiagramHandler implements CommandHandler {
    constructor(private readonly messageService: MessageService,
        protected readonly editorManager: EditorManager,
        protected readonly openerService: OpenerService,
        protected readonly shell: ApplicationShell) {
    }

    async execute(...args: any[]) {
        const editor = this.editorManager.currentEditor
        const abc = this.shell.currentWidget;
        if (abc !== undefined) {
            console.log("currentw idget" + abc.id)
        }
        if (editor !== undefined) {
            const uri = editor.editor.uri

            const openers = this.openerService.getOpeners(uri)
            this.messageService.info("inside OpenInDiagramHandler--second--URI " + uri);
            openers.then(openers => {
                const opener = openers.find(opener => opener instanceof DiagramManagerImpl)
                if (opener !== undefined)
                    opener.open(uri)
            })
        }
    }

    /**
  * Reveals and selects node in the file navigator to which given widget is related.
  * Does nothing if given widget undefined or doesn't have related resource.
  *
  * @param widget widget file resource of which should be revealed and selected
  */
    async selectWidgetFileNode(widget: OutlineViewWidget): Promise<void> {
        console.log("BAHUBALI" + Navigatable.is(widget))
        const { model } = await widget;
        console.log("BHISMA" + model)
        if (model !== undefined)
            console.log("SURMA" + model.selectedNodes)
    }
}

@injectable()
export class DiagramCommandContribution extends AbstractViewContribution<OutlineViewWidget> implements CommandContribution {

    constructor(
        @inject(EditorManager) protected readonly editorManager: EditorManager,
        @inject(OpenerService) protected readonly openerService: OpenerService,
        @inject(ApplicationShell) protected readonly shell: ApplicationShell
    ) {
        super({
            widgetId: OUTLINE_WIDGET_FACTORY_ID,
            widgetName: 'Outline',
            defaultWidgetOptions: {
                area: 'right',
                rank: 500
            },
            toggleCommandId: 'outlineView:toggle',
            toggleKeybinding: 'ctrlcmd+shift+o'
        });
    }

    registerCommands(registry: CommandRegistry): void {
        registry.registerCommand(TURNDiagramCommand, {
            execute: () => {
                this.generateDiagram(this.shell.currentWidget);
            }
        })
        registry.registerCommand(TURNStrategyCommand, {
            execute: () => {
                this.generateStrategyDiagram(this.shell.currentWidget);
            },
            isVisible: () => this.strategyVisibilityCheck(this.shell.currentWidget)
        })


    }

    async generateDiagram(widget: Widget | undefined) {
        const abc = <OutlineViewWidget>widget
        const { model } = abc;
        const def = model.selectedNodes;
        for (let node of def) {
            if (node !== undefined) {
                const a = MonacoOutlineSymbolInformationNode.is(node);
                console.log("MOnaco" + a)
                console.log("heyaaaaaaaaaaaaaaaa Name" + node.name);
                const j = node as MonacoOutlineSymbolInformationNode;
                console.log("heyaaaaaaaaaaaaaaaa JJJ Name" + j.name);
                const editor = this.editorManager.currentEditor;
                if (editor !== undefined) {
                    const uri = editor.editor.uri
                    const encodedURI = uri.withFragment(node.name);
                    console.log("Encoded URI" + encodedURI);
                    const openers = this.openerService.getOpeners(encodedURI)
                    openers.then(openers => {
                        const opener = openers.find(opener => opener instanceof DiagramManagerImpl)
                        if (opener !== undefined)
                            opener.open(encodedURI, node.name);
                    })
                }
            }
        }
    }

    async generateStrategyDiagram(widget: Widget | undefined) {
        const abc = <OutlineViewWidget>widget
        const { model } = abc;
        const def = model.selectedNodes;
        let concatstring = ""
        for (let node of def) {
            concatstring = concatstring.concat(node.name);
            concatstring = concatstring.concat("$");
        }
        const editor = this.editorManager.currentEditor;
        if (editor !== undefined) {
            const uri = editor.editor.uri
            const encodedURI = uri.withFragment(concatstring);
            console.log("Encoded URI" + encodedURI);
            const openers = this.openerService.getOpeners(encodedURI)
            openers.then(openers => {
                const opener = openers.find(opener => opener instanceof DiagramManagerImpl)
                if (opener !== undefined)
                    opener.open(encodedURI, concatstring);
            })
        }

    }

    private strategyVisibilityCheck(widget: Widget | undefined): boolean {
        const outlineWidget = <OutlineViewWidget>widget
        const { model } = outlineWidget;
        const mySelectedNodes = model.selectedNodes;
        if (mySelectedNodes.length > 1)
            return true
        else
            return false;
    }

}
