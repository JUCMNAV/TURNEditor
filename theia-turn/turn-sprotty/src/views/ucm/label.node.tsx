/** @jsx svg */
import { svg } from 'snabbdom-jsx';

import { VNode } from "snabbdom/vnode";
import {getSubType, IView, RenderingContext, setAttr, SLabel} from "sprotty/lib";

export class LabelNodeView implements IView {

    static readonly TYPE = 'label:node';

    render(label: Readonly<SLabel>, context: RenderingContext): VNode {
        const vnode = <text class-ucm-label={true}>{label.text}</text>;
        const subType = getSubType(label);
        if (subType)
            setAttr(vnode, 'class', subType);
        return vnode;
    }
}