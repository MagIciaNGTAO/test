/*
 * Copyright 2014 Fitbur.
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
package com.fitbur.test.hk2.mockito;

import javax.inject.Inject;
import javax.inject.Named;
import org.glassfish.hk2.api.Injectee;
import org.glassfish.hk2.api.InjectionResolver;
import static org.glassfish.hk2.api.InjectionResolver.SYSTEM_RESOLVER_NAME;
import org.glassfish.hk2.api.ServiceHandle;
import org.jvnet.hk2.annotations.Service;
import static org.mockito.Mockito.spy;

/**
 *
 * @author Sharmarke Aden
 */
@Service
public class InjectSpyResolver implements InjectionResolver<InjectSpy> {

    private final InjectionResolver<Inject> systemResolver;

    @Inject
    InjectSpyResolver(@Named(SYSTEM_RESOLVER_NAME) InjectionResolver systemResolver) {
        this.systemResolver = systemResolver;
    }

    @Override
    public Object resolve(Injectee injectee, ServiceHandle<?> root) {
        return spy(systemResolver.resolve(injectee, root));
    }

    @Override
    public boolean isConstructorParameterIndicator() {
        return false;
    }

    @Override
    public boolean isMethodParameterIndicator() {
        return false;
    }

}
