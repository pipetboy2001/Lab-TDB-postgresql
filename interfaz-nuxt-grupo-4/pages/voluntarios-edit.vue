<template>
    <div class="container" style="width:700px;">
      <h1>EDITAR DATOS DE VOLUNTARIO</h1>
      <form>
        <div class="form-group">
        <label for="nombre">Nombre</label>
          <input type="text" class="form-control" minlength="3" maxlength="100" id="nombre" v-model="form.nombre" required>
          <small id="nombreAyuda" class="form-text text-muted">Ingrese el nombre a cambiar.</small>
        </div>
          <div class="form-group">
          <label for="fecha">Fecha de nacimiento</label>
          <input type="text" class="form-control" minlength="10" maxlength="10" id="fecha" v-model="form.fecha" required>
          <small id="fechaAyuda" class="form-text text-muted">Ingrese la nueva fecha con formato YYYY/MM/DD.</small>
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
      voluntarioId: '',
      form: {
        id: null,
        nombre: '',
        fnacimiento: ''
      }
    }
  },
  methods: {
    editar () {
      console.log(this.form)
      this.id = this.voluntarioId
      axios.put('http://localhost:3000/voluntarios', this.form)
      this.$router.push('/voluntarios')
    },
    cancelar () {
      this.$router.push('/voluntarios')
    }
  },
  mounted: function () {
    this.voluntarioId = this.$route.query.id
    const endpointVoluntario = 'http://localhost:3000/voluntarios/' + this.institucionId
    axios.get(endpointVoluntario).then(
      response => {
        this.form.id = this.voluntarioId
        this.form.nombre = response.data.nombre
        this.form.descrip = response.data.fnacimiento
        console.log(this.form)
      }
    )
  }
}
</script>
<style>

</style>
