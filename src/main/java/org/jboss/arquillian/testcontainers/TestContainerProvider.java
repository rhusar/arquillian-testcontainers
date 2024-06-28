/*
 * JBoss, Home of Professional Open Source
 * Copyright 2024 Red Hat Inc. and/or its affiliates and other contributors
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jboss.arquillian.testcontainers;

import java.lang.annotation.Annotation;

import org.jboss.arquillian.core.api.Instance;
import org.jboss.arquillian.core.api.annotation.Inject;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.arquillian.test.spi.annotation.ClassScoped;
import org.jboss.arquillian.container.test.impl.enricher.resource.OperatesOnDeploymentAwareProvider;
import org.testcontainers.containers.GenericContainer;

public class TestContainerProvider extends OperatesOnDeploymentAwareProvider {
    @Inject
    @ClassScoped
    private Instance<GenericContainer<?>> genericContainerInstance;

    @Override
    public Object doLookup(ArquillianResource resource, Annotation... qualifiers) {
        return genericContainerInstance.get();
    }

    @Override
    public boolean canProvide(Class<?> type) {
        return GenericContainer.class.isAssignableFrom(type);
    }
}
