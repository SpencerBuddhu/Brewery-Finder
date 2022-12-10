<template>
    <div class="nav">
      <router-link v-bind:to="{ name: 'home' }">Home</router-link>
      <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
    </div>
</template>

<style scoped>
.nav {
  font-family: Ubuntu, sans-serif;
  
  display: flex;
  justify-content: flex-end;
  padding: 32px 48px;
}
a {
  text-decoration: none;
  color: hsl(0, 0%, 100%);
  margin-right: 16px;
}
a:hover {
  color: hsl(240, 2%, 79%);
}
.router-link-exact-active {
  font-weight: 500;
}
</style>