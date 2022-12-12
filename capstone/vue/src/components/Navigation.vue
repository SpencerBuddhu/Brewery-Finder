<template>
    <div class="nav">
      <img class="nav-logo" src="../assets/main_logo.png" alt="Cheers! Brewery Finder Logo">
      <div class="nav-links">
        <router-link v-bind:to="{ name: 'home' }">Home</router-link>
        <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
      </div>
    </div>
</template>

<style scoped>
.nav {
  font-family: Overpass, sans-serif;
  display: flex;
  justify-content: space-between;
  align-items: center;
  width: 1280px;
  padding: 32px 0;
  margin: 0 auto;
}
a {
  text-decoration: none;
  background-color: hsl(353, 100%, 62%);
  color: hsl(0, 0%, 100%);
  padding: 8px 16px;
  margin-right: 24px;
  font-size: 24px;
  border-radius: 8px;
}
a:hover {
  color: hsl(207, 13%, 34%);
}
.nav-logo {
  width: 96px;
  margin-left: 16px;
}
/* .router-link-exact-active {
  font-weight: 600;
} */
</style>