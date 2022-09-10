<template>
    <div class="container" style="width:700px;">
      <h1>EDITAR DATOS</h1>
      <form>
        <div class="form-group">
        <label for="nombre">Nombre</label>
          <input type="text" class="form-control" maxlength="100" id="nombre" v-model="form.nombre" required>
          <small id="nombreAyuda" class="form-text text-muted">Ingrese el nombre a cambiar.</small>
        </div>
          <div class="form-group">
          <label for="descripcion">Descripción</label>
          <input type="text" class="form-control" maxlength="400" id="description" v-model="form.descrip" required>
          <small id="descripcionAyuda" class="form-text text-muted">Ingrese la descripción a cambiar.</small>
        </div>
        <button type="submit" class="btn btn-primary" v-on:click="editar()">EDITAR</button>
        <button type="submit" class="btn btn-dark" v-on:click="cancelar()">CANCELAR</button>
      </form>
    </div>

</template>

<script>

//  import router from '@/router'
import axios from 'axios'

export default {
  name: 'EDITAR',
  data: function () {
    return {
      institucionId: '',
      form: {
        id: null,
        nombre: '',
        descrip: ''
      }
    }
  },
  methods: {
    editar () {
      console.log(this.form)
      this.id = this.institucionId
      axios.put('http://localhost:3000/instituciones', this.form)
      this.$router.push('/instituciones')
    },
    cancelar () {
      this.$router.push('/instituciones')
    }
  },
  mounted: function () {
    this.institucionId = this.$route.params.id
    const endpointInstitucion = 'http://localhost:3000/instituciones/' + this.institucionId
    axios.get(endpointInstitucion).then(
      response => {
        this.form.id = this.institucionId
        this.form.nombre = response.data.nombre
        this.form.descrip = response.data.descrip
      }
    )
  }
}
</script>
<style>

</style>
