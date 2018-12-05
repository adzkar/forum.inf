# Forum.inf
"Reach the top"'s Forum

## Endpoint

**Base URL**: https://localhost:8080/api

### Artikel

- **/artikel**  [Get]

- **/artikel/{id}** [Get]

- **/artikel/create** [POST]

Example JSON Post Request:

```
  {
    "judul": "Contoh Judul Post",
    "isi": "Isinya"
  }
```

- **/artikel/delete/{id}** [Delete]

#### Komentar

- **/artikel/{id}/komentar/create** [POST]

Example JSON Post Request:

```
  {
    "judul": "Contoh Judul Komentar",
    "isi": "Naisu"
  }
```

> Note: To Use POST Request Create Artikel and Create Komentar must login with this "/user/login"

### User

- **/user**  [Get]

- **/user/{id}**  [Get]

- **/user/create**  [POST]

Example JSON Post Request:

```
  {
    "nama": "Tayo",
    "email": "tayo@tayo.com",
    "pass": "heytayodiabiskecilramah"
  }
```

- **/user/login**  [POST]

Example JSON Post Request:

```
  {
    "email": "tayo@tayo.com",
    "pass": "heytayodiabiskecilramah"
  }
```

Return Boolean

- **/user/logout**  [GET]

- **/user/deletebyemail/{email}**  [DELETE]

Example Endpoint:

```
  https://localhost:8080/api/user/deletebyemail/tayo@tayo.com
```
- **/user/delete/{id}**  [DELETE]

Example Endpoint:

```
  https://localhost:8080/api/user/delete/1
```

> Note: min 8 char for pass attribute
