/** @jsx svg */

import { svg } from 'snabbdom-jsx';
import {IView, RenderingContext} from "sprotty/lib";
import {TURNNode} from "../../models";
import { VNode } from "snabbdom/vnode";

export class ResponsibilityNodeView implements IView {

    static readonly TYPE = 'turnnode:responsibility';

    render(node: TURNNode, context: RenderingContext): VNode {
        const Cx = node.getDimension() / 2;
        const Cy = Math.max(node.bounds.height / 2, 0);
        const p1 = "M " + Cx + " " + Cy + " l -25 -25";
        const p2 = "M " + Cx + " " + Cy + " l 25 -25";
        const p3 = "M " + Cx + " " + Cy + " l -25 25";
        const p4 = "M " + Cx + " " + Cy + " l 25 25";


        return <g class-resp-node={true}>
            <line class-ucm-edge={true} x1={-2} x2={Math.max(node.bounds.width + 2, 0)} y1={Cy} y2={Cy} />
            <path d={p1}/>
            <path d={p2}/>
            <path d={p3}/>
            <path d={p4}/>
            {context.renderChildren(node)}
        </g>;
    }
}