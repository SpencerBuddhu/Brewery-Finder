<template>
    <div>
        <h1>{{brewery.breweryName}}</h1>
        <img v-bind:src="brewery.breweryLogo" v-bind:alt="brewery.breweryName">
        <p>{{brewery.breweryHistory}}</p>
    </div>
</template>

<script>
export default {
    name: 'brewery-info',
    props: ['brewery']
}
</script>