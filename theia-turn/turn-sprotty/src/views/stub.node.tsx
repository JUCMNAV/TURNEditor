/** @jsx svg */

import { svg } from 'snabbdom-jsx';
import {IView, RenderingContext} from "sprotty/lib";
import {TURNNode} from "../models";
import { VNode } from "snabbdom/vnode";

export class StubNodeView implements IView {

    static readonly TYPE = 'turnnode:stub';

    render(node: TURNNode, context: RenderingContext): VNode {
        const hwidth = (node.getDimension() / 2);
        const hheight = (node.getDimension() / 2);
        const initpos = "M 0 " + hheight;
        const TLedge = "l " + hwidth + " " + (-hheight);
        const TRedge = "l " + hwidth + " " + hheight;
        const BRedge = "l " + -hwidth + " " + hheight;
        const BLedge = "z";

        const diamond =  initpos + " " + TLedge + " " + TRedge + " " + BRedge + " " + BLedge;
        const vnode = <g class-sprotty-node={true} >
            {context.renderChildren(node)}
            <path d={diamond} fill="none" stroke="white"/>
        </g>;
        return vnode;
    }
}