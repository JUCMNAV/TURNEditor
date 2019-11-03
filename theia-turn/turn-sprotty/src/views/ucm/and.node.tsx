/** @jsx svg */

import { svg } from 'snabbdom-jsx';
import {IView, RenderingContext, setAttr} from "sprotty/lib";
import {TURNNode} from "../../models";
import { VNode } from "snabbdom/vnode";

export class AndNodeView implements IView {

    static readonly TYPE_JOIN = 'turnnode:andJoin';
    static readonly TYPE_FORK = 'turnnode:andFork';

    // TODO: implement dynamic sizing based on # of children
    render(node: TURNNode, context: RenderingContext): VNode {
        const vnode = <g class-ucm-node={true}>
            <rect x={0} y={0} width={node.getDimension() / 4} height={node.getDimension()}/>
            {context.renderChildren(node)}
        </g>;
        setAttr(vnode, 'class', node.cssClass);
        return vnode;
    }
}