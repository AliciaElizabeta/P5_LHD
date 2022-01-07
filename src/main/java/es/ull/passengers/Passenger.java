/*
 * ========================================================================
 *
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * ========================================================================
 */
package es.ull.passengers;

import java.util.Arrays;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import es.ull.flights.Flight;

/*! \brief Clase Passenger 
*
* Contiene informacion relativa a los pasajeros
* como un identificador, su nombre, el codigo de país y
* el vuelo asignado si lo tienen.
*/
public class Passenger {

    private String identifier;
    private String name;
    private String countryCode;
    private Flight flight;

    //! Constructor parametrizado de la clase.
    /*!
      Requiere el identificador del pasajero, su nombre y su país de origen.
    */
    public Passenger(String identifier, String name, String countryCode) {
        if (!Arrays.asList(Locale.getISOCountries()).contains(countryCode)) {
            throw new RuntimeException("Invalid country code");
        }

        this.identifier = identifier;
        this.name = name;
        this.countryCode = countryCode;
    }

    //! Método getIdentifier.
    /*!
      Retorna el identificador del pasajero.
    */
    public String getIdentifier() {
        return identifier;
    }

    //! Método getName.
    /*!
      Retorna el nombre del pasajero.
    */
    public String getName() {
        return name;
    }

    //! Método getCountryCode.
    /*!
      Retorna el código del país del pasajero.
    */
    public String getCountryCode() {
        return countryCode;
    }

    //! Método getFlight.
    /*!
      Retorna el vuelo del pasajero si es que lo tiene.
    */
    public Flight getFlight() {
        return flight;
    }

    //! Método joinFlight
    /*!
      Añade al pasajero a un vuelo que se le indica por parametro.
    */
    public void joinFlight(Flight flight) {
        Flight previousFlight = this.flight;
        if (null != previousFlight) {
            if (!previousFlight.removePassenger(this)) {
                throw new RuntimeException("Cannot remove passenger");
            }
        }
        setFlight(flight);
        if (null != flight) {
            if (!flight.addPassenger(this)) {
                throw new RuntimeException("Cannot add passenger");
            }
        }
    }

    //! Método setFlight
    /*!
      Establece el vuelo del pasajero como el vuelo que se pasa por parametro.
    */
    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    //! Método toString
    /*!
      Devuelve un string formateado con la informacion del pasajero.
    */
    @Override
    public String toString() {
        return "Passenger " + getName() + " with identifier: " + getIdentifier() + " from " + getCountryCode();
    }
}
