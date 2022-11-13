<script>
location.reload()
</script>
<template>
  <div class="container">
    <h1>INDEX</h1>
    <div>
      ---
    </div>
    <!--Bootstrp table-->
    <button v-on:click="instituciones()" type="button " class="btn btn-warning ">INSTITUCIONES</button>
    <button v-on:click="voluntarios()" type="button " class="btn btn-warning ">VOLUNTARIOS</button>
    <button v-on:click="emergencias()" type="button " class="btn btn-warning ">EMERGENCIAS</button>
    <button v-on:click="tareas()" type="button " class="btn btn-warning ">TAREAS</button>
    <button v-on:click="tareasRegion()" type="button " class="btn btn-warning ">TAREAS POR REGION</button>

    <div></div>

  </div>
</template>

<script>
import axios from 'axios'
export default {
  name: 'indexView',

  methods: {
    instituciones () {
      this.$router.push('/instituciones')
    },
    emergencias () {
      this.$router.push('/emergencias')
    },
    tareas () {
      this.$router.push('/tareas')
    },
    voluntarios () {
      this.$router.push('/voluntarios')
    },
    tareasRegion () {
      this.$router.push('/tareas_region')
    },
  },

}
</script>
