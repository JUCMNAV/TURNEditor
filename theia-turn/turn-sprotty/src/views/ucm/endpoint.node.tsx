/** @jsx svg */

import { svg } from 'snabbdom-jsx';
import {IView, RenderingContext, setAttr} from "sprotty/lib";
import {TURNNode} from "../../models";
import { VNode } from "snabbdom/vnode";

export class EndPointNodeView implements IView {

    static readonly TYPE = 'turnnode:endpoint';

    render(node: TURNNode, context: RenderingContext): VNode {
        const vnode = <g class-ucm-node={true}>
            <rect x={0} y={0} width={node.getDimension() / 2} height={node.getDimension()}/>
            {context.renderChildren(node)}
        </g>;
        setAttr(vnode, 'class', node.cssClass);
        return vnode;
    }
}