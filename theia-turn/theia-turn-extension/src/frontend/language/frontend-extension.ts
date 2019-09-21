/*
 * Copyright (C) 2017 TypeFox and others.
 *
 * Licensed under the Apache License, Version 2.0 (the "License") you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0
 */

import { ContainerModule, interfaces } from 'inversify'
import { CommandContribution, MenuContribution } from '@theia/core/lib/common'
import { LanguageClientContribution } from '@theia/languages/lib/browser'
import { TurnLanguageClientContribution, OUTLINE_CONTEXT_MENU, DiagramCommandContribution, DiagramMenuContribution } from './turn-language-client-contribution'
import { DiagramConfiguration } from 'theia-sprotty/lib'
import { TURNDiagramConfiguration } from '../turndiagram/di.config'
import { DiagramManager, DiagramManagerProvider } from 'theia-sprotty/lib'
import { TURNDiagramManager } from '../turndiagram/turn-diagram-manager'
import { defaultTreeProps, TreeWidget } from '@theia/core/lib/browser'
import { TreeProps } from '@theia/core/lib/browser'
import { FrontendApplicationContribution, OpenHandler, createTreeContainer } from '@theia/core/lib/browser'
import { configuration } from './turn-monaco-language'
import { TURNCommandContribution } from './turn-commands'
import { MonacoEditorProvider } from '@theia/monaco/lib/browser/monaco-editor-provider'
import { TURNMonacoEditorProvider } from "../monaco/turn-monaco-editor-provider"
import 'sprotty/css/sprotty.css'
import 'theia-sprotty/css/theia-sprotty.css'
import { ContextMenuCommands } from './dynamic-commands'
import { ThemeManager } from '../turndiagram/theme-manager'
import { OutlineViewWidgetFactory, OutlineViewWidget } from '@theia/outline-view/lib/browser/outline-view-widget'
import { LanguageGrammarDefinitionContribution } from '@theia/monaco/lib/browser/textmate/textmate-contribution'
import { YangTextmateContribution } from './yang-textmate-contribution'

export const FILE_NAVIGATOR_PROPS = <TreeProps>{
    ...defaultTreeProps,
    contextMenuPath: OUTLINE_CONTEXT_MENU,
    multiSelect: true
};

export default new ContainerModule((bind: interfaces.Bind, unbind: interfaces.Unbind, isBound: interfaces.IsBound, rebind: interfaces.Rebind) => {
    monaco.languages.register({
        id: 'turn',
        aliases: ['Turn', 'turn'],
        extensions: ['.turn'],
        mimetypes: ['text/turn']
    })
    monaco.languages.onLanguage('turn', () => {
        monaco.languages.setLanguageConfiguration('turn', configuration)
    });
    bind(CommandContribution).to(TURNCommandContribution).inSingletonScope()
    bind(TurnLanguageClientContribution).toSelf().inSingletonScope()
    bind(CommandContribution).to(DiagramCommandContribution);
    bind(MenuContribution).to(DiagramMenuContribution);
    bind(LanguageClientContribution).toDynamicValue(ctx => ctx.container.get(TurnLanguageClientContribution))
    bind(DiagramConfiguration).to(TURNDiagramConfiguration).inSingletonScope()
    bind(DiagramManagerProvider).toProvider<DiagramManager>(context => {
        return () => {
            return new Promise<DiagramManager>((resolve) =>
                resolve(context.container.get(TURNDiagramManager))
            )
        }
    }).whenTargetNamed('turn-diagram')
    bind(TURNDiagramManager).toSelf().inSingletonScope()
    bind(FrontendApplicationContribution).toDynamicValue(context => context.container.get(TURNDiagramManager))
    bind(OpenHandler).toDynamicValue(context => context.container.get(TURNDiagramManager))
    bind(ContextMenuCommands).to(ContextMenuCommands).inSingletonScope()
    rebind(MonacoEditorProvider).to(TURNMonacoEditorProvider).inSingletonScope()
    rebind(OutlineViewWidgetFactory).toFactory(ctx =>
        () => createOutlineViewWidgetWithContextMenu(ctx.container)
    );
    bind(ThemeManager).toSelf().inSingletonScope();
    bind(LanguageGrammarDefinitionContribution).to(YangTextmateContribution).inSingletonScope()
})

function createOutlineViewWidgetWithContextMenu(parent: interfaces.Container): OutlineViewWidget {
    const child = createTreeContainer(parent);

    child.unbind(TreeWidget);
    child.bind(OutlineViewWidget).toSelf();

    child.rebind(TreeProps).toConstantValue(FILE_NAVIGATOR_PROPS);

    return child.get(OutlineViewWidget);
}
