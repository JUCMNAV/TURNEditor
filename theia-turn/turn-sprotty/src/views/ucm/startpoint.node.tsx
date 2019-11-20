/** @jsx svg */

import { svg } from 'snabbdom-jsx';
import {IView, RenderingContext} from "sprotty/lib";
import {TURNNode} from "../../models";
import { VNode } from "snabbdom/vnode";

export class StartPointNodeView implements IView {

    static readonly TYPE = 'turnnode:startpoint';

    render(node: TURNNode, context: RenderingContext): VNode {
        const yOffset = Math.max(node.bounds.height / 2, 0);
        const vnode = <g class-ucm-node={true} >
            {context.renderChildren(node)}
            <circle class-body={true} class-selected={node.selected}
                    cx={node.getDimension() / 2}
                    cy={yOffset}
                    r={node.getDimension() / 2}
            />
        </g>;
        return vnode;
    }
}