<template>
  <div class="container" style="width:700px;">
    <h1>AÑADIR NUEVA INSTITUCION</h1>
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
      <button type="submit" class="btn btn-dark" v-on:click="cancelar()">CANCELAR</button>
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
        descrip: '',
        token: ''
      }
    }
  },
  methods: {
    crear () {
      this.form.token = localStorage.getItem('token')
      axios.post('http://localhost:3000/instituciones', this.form)
        .then(data => {
          console.log(data)
          this.makeToast('Listo', 'Institucion agregada', 'success')
          this.$router.push('../instituciones')
        }).catch(error => {
          console.log(error)
          this.makeToast('Error', 'No se pudo agregar la institucion', 'error')
        })
    },
    cancelar () {
      this.$router.push('../instituciones')
    },
    makeToast (titulo, texto, tipo) {
      this.toastCount++
      this.$bvToast.toast(texto, {
        title: titulo,
        variant: tipo,
        autoHideDelay: 10000,
        appendToast: true
      })
    }

  }
}
</script>
<style>

</style>
