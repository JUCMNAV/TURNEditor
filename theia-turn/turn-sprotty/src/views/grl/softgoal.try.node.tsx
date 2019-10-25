/** @jsx svg */

import { svg } from 'snabbdom-jsx';
import {IView, RenderingContext, setAttr} from "sprotty/lib";
import {TURNNode} from "../../models";
import { VNode } from "snabbdom/vnode";

export class SoftGoalTryNodeView implements IView {
    render(example: TURNNode, context: RenderingContext): VNode {
        const vnode = <g class-sprotty-example="{true}">
            <rect class-example={true} class-selected={example.selected} class-example-label={true}
                  x={0} y={0}
                  width={Math.max(0, example.bounds.width)} height={Math.max(0, example.bounds.height)}
                  rx={Math.max(example.size.width * 0.5, 0)} ry={10} />
            {context.renderChildren(example)}
        </g>;
        setAttr(vnode, 'class', example.cssClass);
        return vnode;
    }
}