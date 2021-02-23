package com.myorg.cbs;

public interface ServiceUri {
    String BASE_URL = "/cbs/v1";

    String USER_BASE_URL = BASE_URL + "/user";
    String USER_BY_ID_URL = USER_BASE_URL + "/{id}";

    String ACADEMY_BASE_URL = BASE_URL + "/academy";
    String ACADEMY_BY_ID_URL = ACADEMY_BASE_URL + "/{id}";
    String ACADEMY_BY_CITY_ID_URL = ACADEMY_BASE_URL + "/city/{cityId}";

    String GAME_BASE_URL = BASE_URL + "/game";
    String GAME_BY_ID_URL = GAME_BASE_URL + "/{id}";

    String COURT_BASE_URL = BASE_URL + "/court";
    String COURT_BY_ID_URL = COURT_BASE_URL + "/{id}";

    String CITY_BASE_URL = BASE_URL + "/city";
    String CITY_BY_ID_URL = CITY_BASE_URL + "/{id}";

    String BOOKING_BASE_URL = BASE_URL + "/booking";
    String BOOKING_BY_ID_URL = BOOKING_BASE_URL + "/{id}";
    String BOOKING_BY_USER_ID_URL = BOOKING_BASE_URL + "/user/{userId}";
    String AVAILABLE_SLOTS_BY_COURT_ID_URL = BOOKING_BASE_URL + "/slot";

}
