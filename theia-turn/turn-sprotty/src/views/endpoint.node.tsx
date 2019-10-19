/** @jsx svg */

import { svg } from 'snabbdom-jsx';
import {IView, RenderingContext, setAttr} from "sprotty/lib";
import {TURNNode} from "../models";
import { VNode } from "snabbdom/vnode";

export class EndPointNodeView implements IView {

    static readonly TYPE = 'turnnode:endpoint';

    render(node: TURNNode, context: RenderingContext): VNode {
        const vnode = <g class-sprotty-node={true}>
            <rect class-body={true} class-selected={node.selected}
                  x={0} y={0}
                  width={Math.max(0, node.bounds.width)} height={Math.max(0, node.bounds.height)}
                  rx={Math.max(node.size.height * 0.5, 0)} ry={Math.max(node.size.height * 0.5, 0)} />
            {context.renderChildren(node)}
        </g>;
        setAttr(vnode, 'class', node.cssClass);
        return vnode;
    }
}