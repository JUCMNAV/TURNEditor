/** @jsx svg */

import { svg } from 'snabbdom-jsx';
import {IView, RenderingContext} from "sprotty/lib";
import {TURNNode} from "../../models";
import { VNode } from "snabbdom/vnode";

export class EndPointNodeView implements IView {

    static readonly TYPE = 'turnnode:endpoint';

    render(node: TURNNode, context: RenderingContext): VNode {
        const vnode = <g class-sprotty-node={true}>
            <rect class-body={true} class-selected={node.selected}
                  x={0} y={0}
                  width={node.getDimension() / 2} height={node.getDimension()}
                  fill="white"/>
            {context.renderChildren(node)}
        </g>;
        return vnode;
    }
}