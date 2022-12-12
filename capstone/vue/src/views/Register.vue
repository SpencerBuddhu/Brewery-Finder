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
        <form class="form-register-alt" @submit.prevent="register">
          <h2 class="h3 mb-3 font-weight-normal">Create Account</h2>
          <div class="alert alert-danger" role="alert" v-if="registrationErrors">
            {{ registrationErrorMsg }}
          </div>
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
          <input
            type="password"
            id="confirmPassword"
            class="form-control"
            placeholder="Confirm Password"
            v-model="user.confirmPassword"
            required
          />
          
          <button class="btn btn-lg btn-primary btn-block" type="submit">
            Create Account
          </button>
          <router-link :to="{ name: 'login' }">Have an account?</router-link>
        </form>
      </div>
    </div>
  </div>
  <!-- <div id="register" class="text-center">
    <form class="form-register" @submit.prevent="register">
      <h2 class="h3 mb-3 font-weight-normal">Create Account</h2>
      <div class="alert alert-danger" role="alert" v-if="registrationErrors">
        {{ registrationErrorMsg }}
      </div> -->
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
      <input
        type="password"
        id="confirmPassword"
        class="form-control"
        placeholder="Confirm Password"
        v-model="user.confirmPassword"
        required
      />
      
      <button class="btn btn-lg btn-primary btn-block" type="submit">
        Create Account
      </button>
      <router-link :to="{ name: 'login' }">Have an account?</router-link>
    </form>
  </div> -->
</div>
</template>

<script>
import authService from '../services/AuthService';

export default {
  name: 'register',
  data() {
    return {
      user: {
        username: '',
        password: '',
        confirmPassword: '',
        role: 'beerlover',
      },
      registrationErrors: false,
      registrationErrorMsg: 'There were problems registering this user.',
    };
  },
  methods: {
    register() {
      if (this.user.password != this.user.confirmPassword) {
        this.registrationErrors = true;
        this.registrationErrorMsg = 'Password & Confirm Password do not match.';
      } else {
        authService
          .register(this.user)
          .then((response) => {
            if (response.status == 201) {
              this.$router.push({
                path: '/login',
                query: { registration: 'success' },
              });
            }
          })
          .catch((error) => {
            const response = error.response;
            this.registrationErrors = true;
            if (response.status === 400) {
              this.registrationErrorMsg = 'Bad Request: Validation Errors';
            }
          });
      }
    },
    clearErrors() {
      this.registrationErrors = false;
      this.registrationErrorMsg = 'There were problems registering this user.';
    },
  },
};
</script>

<style scoped>
.container {
  display: flex;
  height: 100vh;
  justify-content: center;
  align-items: center;
  padding: 96px 160px;
  background-color: hsl(13, 100%, 72%);
}
.cta {
  font-family: Ubuntu, sans-serif;
  /* text-align: center; */
  color: hsl(0, 0%, 100%);
  /* padding: 96px; */
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
.form-register {
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
.form-register-alt {
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
.form-register > h2 {
  font-size: 32px;
  color: hsl(208, 49%, 24%);
  margin: 32px 0 16px 0;
}
.form-register-alt > h2 {
  font-size: 32px;
  color: hsl(208, 49%, 24%);
  /* margin: 32px 0 16px 0; */
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
  margin: 8px 0;
  padding-left: 16px;
}
</style>
