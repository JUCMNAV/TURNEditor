/*
 * Copyright (C) 2017 TypeFox and others.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0
 */

import { Container, ContainerModule } from "inversify";

import {
    ConsoleLogger, ExpandButtonHandler, ExpandButtonView, HtmlRoot,
    HtmlRootView, LogLevel, PreRenderedElement, PreRenderedView,
    SCompartment, SCompartmentView, SEdge, SGraph,
    SGraphView, SLabel, SLabelView, TYPES, boundsModule,
    buttonModule, configureModelElement, defaultModule, expandModule,
    exportModule, fadeModule, hoverModule, modelSourceModule, moveModule,
    openModule, overrideViewerOptions, selectModule, undoRedoModule,
    viewportModule, SButton, SNode
} from 'sprotty/lib';

import {
    ResourceNodeView, GoalNodeView, SoftGoalNodeView,
    BeliefNodeView, TaskNodeView, IndicatorNodeView, HeaderCompartmentView,
    ModuleNodeView, SoftGoalTryNodeView, ContributeEdgeView,
    CorrelationEdgeView, DecompositionEdgeView, DependencyEdgeView,
    StartPointNodeView, OrNodeView, AndNodeView, PathBoxView, ConnectionEdgeView, LabelNodeView
} from "./views";

import {MAPStartNode, TURNLabel, TURNNode} from "./models";
import { TURNModelFactory } from "./model-factory";
import {EndPointNodeView} from "./views/ucm/endpoint.node";
import {ResponsibilityNodeView} from "./views/ucm/responsibility.node";
import {StubNodeView} from "./views/ucm/stub.node";

const turnDiagramModule = new ContainerModule((bind, unbind, isBound, rebind) => {

    rebind(TYPES.ILogger).to(ConsoleLogger).inSingletonScope();
    rebind(TYPES.LogLevel).toConstantValue(LogLevel.log);
    rebind(TYPES.IModelFactory).to(TURNModelFactory).inSingletonScope();

    const context = { bind, unbind, isBound, rebind };

    configureModelElement(context, 'graph', SGraph, SGraphView);
    configureModelElement(context, 'ucm', SGraph, SGraphView);
    configureModelElement(context, 'pathbox', SNode, PathBoxView);
    configureModelElement(context, 'turnnode:goal', TURNNode, GoalNodeView);
    configureModelElement(context, 'turnnode:softgoal', TURNNode, SoftGoalNodeView);
    configureModelElement(context, 'turnnode:softgoaltry', TURNNode, SoftGoalTryNodeView);
    configureModelElement(context, 'turnnode:belief', TURNNode, BeliefNodeView);
    configureModelElement(context, 'turnnode:actor', TURNNode, ModuleNodeView);
    configureModelElement(context, 'turnnode:task', TURNNode, TaskNodeView);
    configureModelElement(context, 'turnnode:indicator', TURNNode, IndicatorNodeView);
    configureModelElement(context, 'turnnode:resource', TURNNode, ResourceNodeView);
    configureModelElement(context, 'label:heading', SLabel, SLabelView);
    configureModelElement(context, 'label:text', SLabel, SLabelView);
    configureModelElement(context, 'turnlabel:text', TURNLabel, SLabelView);
    configureModelElement(context, 'label:classHeader', SLabel, SLabelView);
    configureModelElement(context, 'comp:comp', SCompartment, SCompartmentView);
    configureModelElement(context, 'comp:classHeader', SCompartment, HeaderCompartmentView);
    configureModelElement(context, 'edge:dependency', SEdge, DependencyEdgeView);
    configureModelElement(context, 'edge:decomposition', SEdge, DecompositionEdgeView);
    configureModelElement(context, 'edge:contribute', SEdge, ContributeEdgeView);
    configureModelElement(context, 'edge:correlated', SEdge, CorrelationEdgeView);
    configureModelElement(context, 'html', HtmlRoot, HtmlRootView);
    configureModelElement(context, 'pre-rendered', PreRenderedElement, PreRenderedView);
    configureModelElement(context, ExpandButtonHandler.TYPE, SButton, ExpandButtonView);
    configureModelElement(context, StartPointNodeView.TYPE, MAPStartNode, StartPointNodeView);
    configureModelElement(context, EndPointNodeView.TYPE, TURNNode, EndPointNodeView);
    configureModelElement(context, ResponsibilityNodeView.TYPE, TURNNode, ResponsibilityNodeView);
    configureModelElement(context, StubNodeView.TYPE, TURNNode, StubNodeView);
    configureModelElement(context, AndNodeView.TYPE_JOIN, TURNNode, AndNodeView);
    configureModelElement(context, AndNodeView.TYPE_FORK, TURNNode, AndNodeView);
    configureModelElement(context, OrNodeView.TYPE_JOIN, TURNNode, OrNodeView);
    configureModelElement(context, OrNodeView.TYPE_FORK, TURNNode, OrNodeView);
    configureModelElement(context, ConnectionEdgeView.TYPE, SEdge, ConnectionEdgeView);
    configureModelElement(context, LabelNodeView.TYPE, SLabel, LabelNodeView);
});

export default function createContainer(widgetId: string): Container {

    const container = new Container();

    container.load(defaultModule, selectModule, moveModule, boundsModule, undoRedoModule, viewportModule,
        hoverModule, fadeModule, exportModule, expandModule, openModule, buttonModule, modelSourceModule,
        turnDiagramModule);

    overrideViewerOptions(container, {
        needsClientLayout: true,
        needsServerLayout: true,
        baseDiv: widgetId
    });

    return container;
}