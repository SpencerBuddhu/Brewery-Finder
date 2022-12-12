<template>
  <div class="container">
    <div class="cta">
      <div class="main-card">
        <div class="main-banner">
          <img class="main-logo" src="../assets/main_logo.png" alt="Cheers! Brewery Finder Logo">
          <div class="main-header">
            <h1 class="main-heading">Brewery Finder</h1>
            <p class="description">Join our community of beer lovers. Find breweries and view their fine selection of beers. Leave a rating or review of a beer and follow your favorite brewery to stay up-to-date.</p>
          </div>
        </div>
        <div class="form-container-alt">
          <form class="form-signin-alt" @submit.prevent="login">
          <h2 class="welcome">Welcome!</h2>
          <div
            class="alert alert-danger"
            role="alert"
            v-if="invalidCredentials"
          >Invalid username and password!</div>
          <div
            class="alert alert-success"
            role="alert"
            v-if="this.$route.query.registration"
          >Thank you for registering, please sign in.</div>
          <!-- <label for="username" class="sr-only">Username</label> -->
          <input
            type="text"
            id="username"
            class="form-control"
            placeholder="Username"
            v-model="user.username"
            required
            autofocus
          />
          <!-- <label for="password" class="sr-only">Password</label> -->
          <input
            type="password"
            id="password"
            class="form-control"
            placeholder="Password"
            v-model="user.password"
            required
          />
          
          <button type="submit">Sign in</button>
          <router-link :to="{ name: 'register' }">Need an account?</router-link>
        </form>
      </div>
      </div>
    </div>
    <!-- <div id="login" class="text-center">
      <form class="form-signin" @submit.prevent="login">
        <h2 class="welcome">Welcome!</h2>
        <div
          class="alert alert-danger"
          role="alert"
          v-if="invalidCredentials"
        >Invalid username and password!</div>
        <div
          class="alert alert-success"
          role="alert"
          v-if="this.$route.query.registration"
        >Thank you for registering, please sign in.</div> -->
        <!-- <label for="username" class="sr-only">Username</label> -->
        <!-- <input
          type="text"
          id="username"
          class="form-control"
          placeholder="Username"
          v-model="user.username"
          required
          autofocus
        /> -->
        <!-- <label for="password" class="sr-only">Password</label> -->
        <!-- <input
          type="password"
          id="password"
          class="form-control"
          placeholder="Password"
          v-model="user.password"
          required
        />
        
        <button type="submit">Sign in</button>
        <router-link :to="{ name: 'register' }">Need an account?</router-link>
      </form>
    </div> -->
  </div>
</template>

<script>
import authService from "../services/AuthService";

export default {
  name: "login",
  components: {},
  data() {
    return {
      user: {
        username: "",
        password: ""
      },
      invalidCredentials: false
    };
  },
  methods: {
    login() {
      authService
        .login(this.user)
        .then(response => {
          if (response.status == 200) {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
            this.$router.push("/");
          }
        })
        .catch(error => {
          const response = error.response;

          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });
    }
  }
};
</script>

<style scoped>
.container {
  display: flex;
  height: 100vh;
  justify-content: center;
  align-items: center;
  /* padding: 96px 160px; */
  background-color: hsl(13, 100%, 72%);
}
.cta {
  font-family: Ubuntu, sans-serif;
  /* text-align: center; */
  color: hsl(0, 0%, 100%);
  /* padding: 96px; */
  /* margin: 0 auto; */
}
.main-card {
  width: 1040px;
  background-color: hsl(207, 13%, 34%);
  /* border: 2px solid black; */
  border-radius: 16px;
  /* text-align: center; */
  padding: 64px;
  box-shadow: 8px 8px 8px rgb(64, 64, 64);
}
.main-banner {
  display: flex;
  align-items: center;
}
.main-logo {
  width: 250px;
}
.main-header {
  padding: 0 32px;
}
.main-heading {
  font-size: 64px;
  margin-bottom: 16px;
}
.description {
  font-size: 20px;
}
.form-signin {
  display: flex;
  width: 500px;
  height: 400px;
  flex-direction: column;
  align-items: center;
  background-color: hsl(0, 0%, 100%);
  font-family: Ubuntu, sans-serif;
  text-align: center;
  border-radius: 16px;
}
.form-container-alt {
  display: flex;
  justify-content: center;
  align-items: center;
  margin-top: 32px;
}
.form-signin-alt {
  display: flex;
  width: 500px;
  height: 400px;
  flex-direction: column;
  align-items: center;
  background-color: hsl(0, 0%, 100%);
  font-family: Ubuntu, sans-serif;
  /* text-align: center; */
  border-radius: 16px;
  padding: 32px 0;
  box-shadow: 8px 8px 8px rgb(48, 48, 48);
}
.form-signin > h2 {
  font-size: 32px;
  color: hsl(208, 49%, 24%);
  margin: 32px 0;
}
.form-signin-alt > h2 {
  font-size: 32px;
  color: hsl(208, 49%, 24%);
  /* margin: 32px 0; */
}
button {
  width: 175px;
  height: 50px;
  color: hsl(0, 0%, 100%);
  border-radius: 8px;
  border: none;
  background-color: hsl(207, 13%, 34%);
  font-size: 16px;
  margin: 16px 0;
}
button:hover {
  background-color: hsl(237, 17%, 21%);
  font-weight: bold;
  cursor: pointer;
}
.form-control {
  width: 350px;
  height: 50px;
  font-size: 16px;
  border: 1px solid hsl(208, 49%, 24%);
  border-radius: 8px;
  margin: 16px 0;
  padding-left: 16px;
}
.alert-danger {
  color: #dc3545;
}
.alert-success {
  color: #198754;
}
</style>
