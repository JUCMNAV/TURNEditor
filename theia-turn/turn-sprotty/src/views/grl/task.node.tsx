/** @jsx svg */

import { svg } from 'snabbdom-jsx';
import {IView, RenderingContext} from "sprotty/lib";
import {TURNNode} from "../../models";
import { VNode } from "snabbdom/vnode";

export class TaskNodeView implements IView {
    render(model: TURNNode, context: RenderingContext): VNode {
        const width = Math.max(0, model.size.width * 0.5);
        const height = Math.max(0, model.size.height * 0.5);
        const rhombStr = "M 0," + height + " l " + width + "," + height + " l " + width + ",-" + height + " l -" + width + ",-" + height + "z";

        return <g class-sprotty-node="{true}" class-choice={true}>
            <path d={rhombStr} class-choice={true}/>
            {context.renderChildren(model)}
        </g>;
    }
}