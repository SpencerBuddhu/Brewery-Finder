<template>
    <div>
        <h1>{{brewery.breweryName}}</h1>
        <img v-bind:src="brewery.breweryLogo" v-bind:alt="brewery.breweryName + ' logo'">
        <img v-bind:src="brewery.breweryImage" v-bind:alt="brewery.breweryName + ' image'">
        <p>{{ address }}</p>
        <p>{{ brewery.phoneNumber }}</p>
        <p>{{ brewery.emailAddress }}</p>
        <p>{{ brewery.websiteUrl }}</p>
        <p>{{ brewery.breweryHistory }}</p>
    </div>
</template>

<script>
export default {
    name: 'brewery-info',
    props: ['brewery'],
    computed: {
        address() {
            return `${this.brewery.streetAddress}, ${this.brewery.city}, ${this.brewery.state} ${this.brewery.zipcode}`;
        }
    }
}
</script>