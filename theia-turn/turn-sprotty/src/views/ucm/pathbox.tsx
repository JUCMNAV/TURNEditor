/** @jsx svg */

import { svg } from 'snabbdom-jsx';
import {IView, RenderingContext} from "sprotty/lib";
import {TURNNode} from "../../models";
import { VNode } from "snabbdom/vnode";

export class PathBoxView implements IView {
    render(node: TURNNode, context: RenderingContext): VNode {
        return <g class-sprotty-node={true} class-pathbox={true}>
            {context.renderChildren(node)}
        </g>;
    }
}