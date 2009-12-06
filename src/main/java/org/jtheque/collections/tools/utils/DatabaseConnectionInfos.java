package org.jtheque.collections.tools.utils;

/*
 * This file is part of JTheque.
 *
 * JTheque is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License.
 *
 * JTheque is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with JTheque.  If not, see <http://www.gnu.org/licenses/>.
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