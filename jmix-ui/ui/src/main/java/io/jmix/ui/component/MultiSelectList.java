/*
 * Copyright 2019 Haulmont.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.jmix.ui.component;

import io.jmix.ui.meta.CanvasBehaviour;
import io.jmix.ui.meta.PropertiesConstraint;
import io.jmix.ui.meta.PropertiesGroup;
import io.jmix.ui.meta.PropertyType;
import io.jmix.ui.meta.StudioComponent;
import io.jmix.ui.meta.StudioProperties;
import io.jmix.ui.meta.StudioProperty;

import java.util.Collection;

/**
 * List select component. Allows to select multiple values.
 *
 * @param <V> value and options type
 */
@StudioComponent(
        caption = "MultiSelectList",
        category = "Components",
        xmlElement = "multiSelectList",
        icon = "io/jmix/ui/icon/component/multiSelectList.svg",
        canvasBehaviour = CanvasBehaviour.SELECT_LIST,
        documentationURL = "https://docs.jmix.io/jmix/%VERSION%/ui/vcl/components/multi-select-list.html"
)
@StudioProperties(
        properties = {
                @StudioProperty(name = "dataContainer", type = PropertyType.DATACONTAINER_REF),
                @StudioProperty(name = "property", type = PropertyType.PROPERTY_PATH_REF, typeParameter = "V"),
                @StudioProperty(name = "optionsContainer", type = PropertyType.COLLECTION_DATACONTAINER_REF,
                        typeParameter = "V"),
                @StudioProperty(name = "captionProperty", type = PropertyType.PROPERTY_PATH_REF),
                @StudioProperty(name = "optionsEnum", type = PropertyType.ENUM_CLASS, typeParameter = "V")
        },
        groups = {
                @PropertiesGroup(constraint = PropertiesConstraint.ALL_OR_NOTHING,
                        properties = {"dataContainer", "property"}),
                @PropertiesGroup(constraint = PropertiesConstraint.ALL_OR_NOTHING,
                        properties = {"optionsContainer", "captionProperty"})
        }
)
public interface MultiSelectList<V> extends SelectList<Collection<V>, V> {
    String NAME = "multiSelectList";
}