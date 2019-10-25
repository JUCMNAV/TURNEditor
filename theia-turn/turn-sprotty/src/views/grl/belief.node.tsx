/** @jsx svg */

import {IView, RenderingContext, setAttr} from "sprotty/lib";
import {TURNNode} from "../../models";
import { VNode } from "snabbdom/vnode";
import { svg } from 'snabbdom-jsx';

export class BeliefNodeView implements IView {

    render(node: TURNNode, context: RenderingContext): VNode {

        const vnode = <g class-sprotty-node="{true}">
            <rect class-body={true} class-selected={node.selected} stroke-dasharray={true}
                  x={0} y={0}
                  width={Math.max(0, node.bounds.width)} height={Math.max(0, node.bounds.height)}
                  rx={Math.max(node.size.width, 0)} ry={40} />
            {context.renderChildren(node)}
        </g>;
        setAttr(vnode, 'class', node.cssClass);
        return vnode;

    }

}