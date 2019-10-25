/** @jsx svg */

import { svg } from 'snabbdom-jsx';
import {IView, RenderingContext, SCompartment} from "sprotty/lib";
import { VNode } from "snabbdom/vnode";

export class HeaderCompartmentView implements IView {
    render(model: SCompartment, context: RenderingContext): VNode {
        const translate = `translate(${model.bounds.x}, ${model.bounds.y})`;
        const parentSize = (model.parent as any).size;
        const width = Math.max(0, parentSize.width);
        const height = Math.max(0, model.size.height);
        return <g transform={translate} class-comp="{true}">
            <rect class-classHeader={true} x={0} y={0} width={width} height={height}/>
            {context.renderChildren(model)}
        </g>;
    }
}