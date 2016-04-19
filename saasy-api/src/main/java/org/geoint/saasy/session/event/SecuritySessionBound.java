/*
 * Copyright 2016 geoint.org.
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
package org.geoint.saasy.session.event;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

/**
 * Session subscription event.
 *
 * @author steve_siebert
 */
public final class SecuritySessionBound {

    private final String subjectGuid;
    private final String sessionGuid;
    private final String subscriberGuid;
    private final ZonedDateTime subscriptionCreatedTime;

    public SecuritySessionBound(String subjectGuid, String sessionGuid,
            String subscriberGuid, ZonedDateTime subscriptionCreatedTime) {
        this.subjectGuid = subjectGuid;
        this.sessionGuid = sessionGuid;
        this.subscriberGuid = subscriberGuid;
        this.subscriptionCreatedTime = subscriptionCreatedTime;
    }

    public String getSubjectGuid() {
        return subjectGuid;
    }

    public String getSessionGuid() {
        return sessionGuid;
    }

    public String getSubscriberGuid() {
        return subscriberGuid;
    }

    public ZonedDateTime getSubscriptionCreatedTime() {
        return subscriptionCreatedTime;
    }

    @Override
    public String toString() {
        return String.format("Subscriber '%s' added to security session '%s' "
                + "at %s.", subscriberGuid, sessionGuid,
                subscriptionCreatedTime.format(DateTimeFormatter.ISO_DATE));
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + Objects.hashCode(this.sessionGuid);
        hash = 23 * hash + Objects.hashCode(this.subscriberGuid);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final SecuritySessionBound other = (SecuritySessionBound) obj;
        if (!Objects.equals(this.sessionGuid, other.sessionGuid)) {
            return false;
        }
        if (!Objects.equals(this.subscriberGuid, other.subscriberGuid)) {
            return false;
        }
        return true;
    }

}
