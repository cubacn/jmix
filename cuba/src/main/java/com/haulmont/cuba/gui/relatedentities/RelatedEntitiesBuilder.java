/*
 * Copyright 2020 Haulmont.
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

package com.haulmont.cuba.gui.relatedentities;

import com.google.common.base.Preconditions;
import com.haulmont.cuba.gui.Screens;
import com.haulmont.cuba.gui.screen.OpenMode;
import io.jmix.core.metamodel.model.MetaClass;
import io.jmix.core.metamodel.model.MetaProperty;
import io.jmix.ui.screen.FrameOwner;
import io.jmix.ui.screen.Screen;
import io.jmix.ui.screen.ScreenOptions;

import java.util.Collection;
import java.util.function.Function;

@Deprecated
public class RelatedEntitiesBuilder extends io.jmix.ui.relatedentities.RelatedEntitiesBuilder {

    public RelatedEntitiesBuilder(io.jmix.ui.relatedentities.RelatedEntitiesBuilder builder) {
        super(builder);
    }

    public RelatedEntitiesBuilder(FrameOwner origin,
                                  Function<io.jmix.ui.relatedentities.RelatedEntitiesBuilder, Screen> handler) {
        super(origin, handler);
    }

    /**
     * Sets {@link Screens.LaunchMode} for the related entities screen and returns the builder for chaining.
     * <p>
     * For example: {@code builder.withLaunchMode(OpenMode.DIALOG).build();}
     *
     * @param launchMode launch mode
     * @return current instance of builder
     * @deprecated Use {@link #withOpenMode(io.jmix.ui.screen.OpenMode)} instead
     */
    @Deprecated
    public RelatedEntitiesBuilder withLaunchMode(Screens.LaunchMode launchMode) {
        Preconditions.checkArgument(launchMode instanceof OpenMode,
                "Unsupported LaunchMode " + launchMode);

        withOpenMode(((OpenMode) launchMode).getOpenMode());
        return this;
    }

    @Override
    public RelatedEntitiesBuilder withProperty(String property) {
        super.withProperty(property);
        return this;
    }

    @Override
    public RelatedEntitiesBuilder withMetaProperty(MetaProperty metaProperty) {
        super.withMetaProperty(metaProperty);
        return this;
    }

    @Override
    public RelatedEntitiesBuilder withEntityClass(Class<?> entityClass) {
        super.withEntityClass(entityClass);
        return this;
    }

    @Override
    public RelatedEntitiesBuilder withOpenMode(io.jmix.ui.screen.OpenMode openMode) {
        super.withOpenMode(openMode);
        return this;
    }

    @Override
    public RelatedEntitiesBuilder withScreenId(String screenId) {
        super.withScreenId(screenId);
        return this;
    }

    @Override
    public <S extends Screen> RelatedEntitiesClassBuilder<S> withScreenClass(Class<S> screenClass) {
        return new RelatedEntitiesClassBuilder<>(this, screenClass);
    }

    @Override
    public RelatedEntitiesBuilder withOptions(ScreenOptions options) {
        super.withOptions(options);
        return this;
    }

    @Override
    public RelatedEntitiesBuilder withMetaClass(MetaClass metaClass) {
        super.withMetaClass(metaClass);
        return this;
    }

    @Override
    public RelatedEntitiesBuilder withSelectedEntities(Collection<?> selectedEntities) {
        super.withSelectedEntities(selectedEntities);
        return this;
    }

    @Override
    public RelatedEntitiesBuilder withFilterCaption(String filterCaption) {
        super.withFilterCaption(filterCaption);
        return this;
    }

    /**
     * Returns launch mode set by {@link #withLaunchMode(Screens.LaunchMode)}.
     *
     * @deprecated Use {@link #getOpenMode()} instead
     */
    @Deprecated
    public Screens.LaunchMode getLaunchMode() {
        return OpenMode.from(getOpenMode());
    }
}
