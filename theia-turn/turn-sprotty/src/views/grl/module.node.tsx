/** @jsx svg */

import { svg } from 'snabbdom-jsx';
import {IView, RenderingContext} from "sprotty/lib";
import {ModuleNode} from "../../models";
import { VNode } from "snabbdom/vnode";

export class ModuleNodeView implements IView {
    render(node: ModuleNode, context: RenderingContext): VNode {
        return <g class-sprotty-node={true} class-module={true} class-mouseover={node.hoverFeedback}>
            <rect class-body={true} class-selected={node.selected}
                  x={0} y={0} rx="5" ry="5"
                  width={Math.max(0, node.bounds.width)} height={Math.max(0, node.bounds.height)} />
            {context.renderChildren(node)}
        </g>;
    }
}