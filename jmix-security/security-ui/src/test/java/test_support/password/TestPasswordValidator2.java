/*
 * Copyright 2022 Haulmont.
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

package test_support.password;

import io.jmix.securityui.password.PasswordValidationContext;
import io.jmix.securityui.password.PasswordValidationException;
import io.jmix.securityui.password.PasswordValidator;
import org.springframework.security.core.userdetails.UserDetails;

public class TestPasswordValidator2 implements PasswordValidator<UserDetails> {

    @Override
    public void validate(PasswordValidationContext<UserDetails> context) throws PasswordValidationException {
        if (context.getPassword().equals(context.getUser().getUsername()))
            throw new PasswordValidationException("Password must be different from username");
    }
}
