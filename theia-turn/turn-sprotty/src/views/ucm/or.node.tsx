/** @jsx svg */

import { svg } from 'snabbdom-jsx';
import {IView, RenderingContext} from "sprotty/lib";
import {TURNNode} from "../../models";
import { VNode } from "snabbdom/vnode";

export class OrNodeView implements IView {

    static readonly TYPE_JOIN = 'turnnode:orJoin';
    static readonly TYPE_FORK = 'turnnode:orFork';

    // TODO: implement dynamic sizing based on # of children
    render(node: TURNNode, context: RenderingContext): VNode {
        const vnode = <g class-ucm-edge={true}>
        </g>;
        return vnode;
    }
}