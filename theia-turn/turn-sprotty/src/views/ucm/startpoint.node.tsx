/** @jsx svg */

import { svg } from 'snabbdom-jsx';
import {IView, RenderingContext} from "sprotty/lib";
import {TURNNode} from "../../models";
import { VNode } from "snabbdom/vnode";

export class StartPointNodeView implements IView {

    static readonly TYPE = 'turnnode:startpoint';

    render(node: TURNNode, context: RenderingContext): VNode {
        const vnode = <g class-sprotty-node={true} >
            {context.renderChildren(node)}
            <circle r={node.getDimension() / 2} fill="white"/>
        </g>;
        return vnode;
    }
}