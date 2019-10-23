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
        const BLy = node.getDimension();
        const TRx = node.getDimension();
        const TRy = 0;
        const BRx = node.getDimension();
        const BRy = node.getDimension();

        return <g class-sprotty-node="{true}" class-choice={true}>
            <line x1={TLx} x2={BRx} y1={TLy} y2={BRy} fill="white"/>
            <line x1={BLx} x2={TRx} y1={BLy} y2={TRy} fill="white"/>
            {context.renderChildren(node)}
        </g>;
    }
}