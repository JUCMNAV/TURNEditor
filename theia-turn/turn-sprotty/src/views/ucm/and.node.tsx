/** @jsx svg */

import { svg } from 'snabbdom-jsx';
import {IView, RenderingContext} from "sprotty/lib";
import {TURNNode} from "../../models";
import { VNode } from "snabbdom/vnode";

export class AndNodeView implements IView {

    static readonly TYPE_JOIN = 'turnnode:andJoin';
    static readonly TYPE_FORK = 'turnnode:andFork';

    // TODO: implement dynamic sizing based on # of children
    render(node: TURNNode, context: RenderingContext): VNode {
        const vnode = <g class-sprotty-node={true}>
            <rect class-body={true} class-selected={node.selected}
                  x={0} y={0}
                  width={node.getDimension() / 2} height={node.getDimension()}
                  fill="none"/>
            {context.renderChildren(node)}
        </g>;
        return vnode;
    }
}