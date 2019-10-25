/** @jsx svg */

import { svg } from 'snabbdom-jsx';
import {IView, RenderingContext} from "sprotty/lib";
import {TURNNode} from "../../models";
import { VNode } from "snabbdom/vnode";

export class OrNodeView implements IView {

    static readonly TYPE = 'turnnode:or';

    // TODO: implement dynamic sizing based on # of children
    render(node: TURNNode, context: RenderingContext): VNode {
        const vnode = <g class-sprotty-node={true}>
            {context.renderChildren(node)}
        </g>;
        return vnode;
    }
}