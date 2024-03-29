import Vue from 'vue'
import Router from 'vue-router'
import Home from '../views/Home.vue'
import Login from '../views/Login.vue'
import Logout from '../views/Logout.vue'
import Register from '../views/Register.vue'
import store from '../store/index'
import Breweries from '../views/Breweries.vue'
import Brewery from '../views/Brewery.vue'
import NewBrewery from '../views/NewBrewery.vue'
import ManageBrewery from '../views/ManageBrewery.vue'
import ManageBeers from '../views/ManageBeers.vue'
import NewBeer from '../views/NewBeer.vue'
import BeerDetail from '../views/BeerDetail.vue'
import NewReview from '../views/NewReview.vue'

Vue.use(Router)

/**
 * The Vue Router is used to "direct" the browser to render a specific view component
 * inside of App.vue depending on the URL.
 *
 * It also is used to detect whether or not a route requires the user to have first authenticated.
 * If the user has not yet authenticated (and needs to) they are redirected to /login
 * If they have (or don't need to) they're allowed to go about their way.
 */

const router = new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: [
    {
      path: '/',
      name: 'home',
      component: Home,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: "/login",
      name: "login",
      component: Login,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/logout",
      name: "logout",
      component: Logout,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/register",
      name: "register",
      component: Register,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/breweries",
      name: "breweries",
      component: Breweries,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: "/breweries/:id",
      name: "brewery",
      component: Brewery,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: "/addBrewery",
      name: "addBrewery",
      component: NewBrewery,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: "/manageBrewery",
      name: "manageBrewery",
      component: ManageBrewery,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: "/manageBeers",
      name: "manageBeers",
      component: ManageBeers,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: "/addBeer",
      name: "addBeer",
      component: NewBeer,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: "/beers/:id",
      name: "beers",
      component: BeerDetail,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: "/addReview",
      name: "addReview",
      component: NewReview,
      meta: {
        requiresAuth: true
      }
    }
  ]
})

router.beforeEach((to, from, next) => {
  // Determine if the route requires Authentication
  const requiresAuth = to.matched.some(x => x.meta.requiresAuth);

  // If it does and they are not logged in, send the user to "/login"
  if (requiresAuth && store.state.token === '') {
    next("/login");
  } else {
    // Else let them go to their next destination
    next();
  }
});

export default router;
