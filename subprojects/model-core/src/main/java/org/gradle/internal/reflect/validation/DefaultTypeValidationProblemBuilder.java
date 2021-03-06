/*
 * Copyright 2021 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.gradle.internal.reflect.validation;

import org.gradle.api.internal.DocumentationRegistry;

public class DefaultTypeValidationProblemBuilder extends AbstractValidationProblemBuilder<TypeProblemBuilder> implements TypeProblemBuilder {
    private Class<?> type;

    public DefaultTypeValidationProblemBuilder(DocumentationRegistry documentationRegistry) {
        super(documentationRegistry);
    }

    @Override
    public TypeProblemBuilder forType(Class<?> type) {
        this.type = type;
        return this;
    }

    public TypeValidationProblem build() {
        if (type == null) {
            throw new IllegalStateException("The type on which the problem should be reported hasn't been set");
        }
        if (shortProblemDescription == null) {
            throw new IllegalStateException("You must provide at least a short description of the problem");
        }
        return new TypeValidationProblem(
            problemId,
            severity,
            TypeValidationProblemLocation.inType(type),
            shortProblemDescription,
            longDescription,
            reason,
            TypeValidationProblem.Payload.of(cacheabilityProblemOnly),
            userManualReference,
            possibleSolutions
        );
    }
}
