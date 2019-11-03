/** @jsx svg */

import { svg } from 'snabbdom-jsx';
import {IView, RenderingContext} from "sprotty/lib";
import {TURNNode} from "../../models";
import { VNode } from "snabbdom/vnode";

export class EmptyNodeView implements IView {

    static readonly TYPE = 'turnnode:empty';

    render(node: TURNNode, context: RenderingContext): VNode {
        return <g>
            // Intentionally made as an empty svg group
        </g>;
    }
}