package org.jtheque.collections.tools.utils;

/*
 * Copyright JTheque (Baptiste Wicht)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/**
 * This class is a bean representing the informations of a connection to a database.
 *
 * @author Baptiste Wicht
 */
public final class DatabaseConnectionInfos {
    private String protocol;
    private String url;
    private String user;
    private String password;

    /**
     * Return the protocol of the connection.
     *
     * @return The protocol of the database connection.
     */
    public String getProtocol() {
        return protocol;
    }

    /**
     * Set the protocol of the connection.
     *
     * @param protocol The new protocol to set.
     */
    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    /**
     * Return the URL of the connection.
     *
     * @return The URL to connect to database.
     */
    public String getUrl() {
        return url;
    }

    /**
     * Set the URL of the connection.
     *
     * @param url The new URL of the connection.
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * Return the user used to connect.
     *
     * @return The user.
     */
    public String getUser() {
        return user;
    }

    /**
     * Set the user used to connect to the database.
     *
     * @param user The new user to set.
     */
    public void setUser(String user) {
        this.user = user;
    }

    /**
     * Return the password used to authenticate the user.
     *
     * @return The password.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Set the password to authenticate the user.
     *
     * @param password The new password to set.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(super.toString() + '\n');

        builder.append("Protocol").append(protocol).append('\n');
        builder.append("URL : ").append(url).append('\n');
        builder.append("User : ").append(user).append('\n');
        builder.append("Password : ").append(password).append('\n');

        return builder.toString();
    }
}
