/** @jsx svg */

import { svg } from 'snabbdom-jsx';
import {IView, RenderingContext} from "sprotty/lib";
import {MAPStartNode} from "../../models";
import { VNode } from "snabbdom/vnode";

export class StartPointNodeView implements IView {

    static readonly TYPE = 'turnnode:startpoint';

    render(node: MAPStartNode, context: RenderingContext): VNode {
        const radius = node.getDimension() / 2;
        const vnode = <g class-sprotty-node={true} >
            {context.renderChildren(node)}
            <circle cx={radius} cy={radius} r={radius} fill="white"/>
        </g>;
        return vnode;
    }
}