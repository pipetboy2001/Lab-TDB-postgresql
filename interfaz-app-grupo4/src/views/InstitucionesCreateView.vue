<template>
  <div class="container" style="width:700px;">
    <form>
      <div class="form-group">
        <label for="nombre">Nombre</label>
        <input type="text" class="form-control" maxlength="100" id="nombre" v-model="form.nombre" required>
        <small id="nombreAyuda" class="form-text text-muted">Ingrese el nombre de la institución.</small>
      </div>
      <div class="form-group">
        <label for="descripcion">Descripción</label>
        <input type="text" class="form-control" maxlength="400" id="description" v-model="form.descrip" required>
        <small id="descripcionAyuda" class="form-text text-muted">Ingrese la descripción de la institución.</small>
      </div>
      <button type="submit" class="btn btn-primary" v-on:click="crear()">CREAR</button>
    </form>
  </div>

</template>

<script>

import axios from 'axios'

export default {
  name: 'CREAR',
  data: function () {
    return {
      form: {
        nombre: '',
        descrip: ''
      }
    }
  },
  methods: {
    crear () {
      axios.post('http://localhost:3000/instituciones', this.form)
      this.$router.push('/instituciones')
    }
  }
}
</script>
<style>

</style>
