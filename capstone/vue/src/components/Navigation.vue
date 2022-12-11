<template>
    <div class="nav">
      <router-link v-bind:to="{ name: 'home' }">Home</router-link>
      <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
    </div>
</template>

<style scoped>
.nav {
  font-family: Overpass, sans-serif;
  display: flex;
  justify-content: flex-end;
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
/* .router-link-exact-active {
  font-weight: 600;
} */
</style>