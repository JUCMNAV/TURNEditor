/** @jsx svg */

import { svg } from 'snabbdom-jsx';
import {IView, RenderingContext} from "sprotty/lib";
import {TURNNode} from "../models";
import { VNode } from "snabbdom/vnode";

export class ResponsibilityNodeView implements IView {

    static readonly TYPE = 'turnnode:responsibility';

    render(node: TURNNode, context: RenderingContext): VNode {
        const TLx = 0;
        const TLy = 0;
        const BLx = 0;
        const BLy = node.size.height;
        const TRx = node.size.width;
        const TRy = 0;
        const BRx = node.size.width;
        const BRy = node.size.height;

        return <g class-sprotty-node="{true}" class-choice={true}>
            <line x1={TLx} x2={BRx} y1={TLy} y2={BRy} fill="black"/>
            <line x1={BLx} x2={TRx} y1={BLy} y2={TRy} fill="black"/>
            {context.renderChildren(node)}
        </g>;
    }
}