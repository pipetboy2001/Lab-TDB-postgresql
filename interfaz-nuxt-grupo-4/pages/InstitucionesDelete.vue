<template>
    <div class="container" style="width:700px;">
      <h1>¿Eliminar Institución?</h1>
      <table class="table table-hover table-striped table-dark table-bordered table-secondary">
        <thead>
        <tr>
          <th scope="col">ID</th>
          <th scope="col">NOMBRE</th>
          <th scope="col">DESCRIPCION</th>
        </tr>
        </thead>
        <tbody>
          <td>{{ form.id }}</td>
          <td>{{ form.nombre }}</td>
          <td>{{ form.descrip }}</td>
        </tbody>
      </table>
      <button type="submit" class="btn btn-danger" v-on:click="eliminar()">ELIMINAR</button>
      <button type="submit" class="btn btn-dark" v-on:click="cancelar()">CANCELAR</button>
    </div>
</template>

<script>

import axios from 'axios'

export default {
  name: 'BORRAR',
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
    cancelar () {
      this.$router.push('/instituciones')
    },
    eliminar () {
      const enviar = {
        id: this.institucionId,
        token: this.form.token
      }
      axios.delete('http://localhost:3000/instituciones/' + this.institucionId, { headers: enviar })
        .then(datos => {
          console.log(datos)
          this.makeToast('BORRADO', 'Institucion eleminada', 'danger')
          this.$router.push('/instituciones')
        }).catch(error => {
          console.log(error)
          this.makeToast('Error', 'No se pudo agregar la institucion', 'error')
        })
    },
    makeToast (titulo, texto, tipo) {
      this.toastCount++
      this.$bvToast.toast(texto, {
        title: titulo,
        variant: tipo,
        autoHideDelay: 5000,
        appendToast: true
      })
    }
  },

  mounted: function () {
    this.institucionId = this.$route.query.id
    const endpointInstitucion = 'http://localhost:3000/instituciones/' + this.institucionId
    axios.get(endpointInstitucion).then(
      response => {
        this.form.id = this.institucionId
        this.form.nombre = response.data.nombre
        this.form.descrip = response.data.descrip
        this.form.toke = localStorage.getItem('token')
      }
    )
  }
}
</script>
<style>

</style>
