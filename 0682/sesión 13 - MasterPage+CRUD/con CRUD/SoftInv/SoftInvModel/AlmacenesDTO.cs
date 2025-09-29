namespace SoftInv.Model
{
    public class AlmacenesDTO
    {
        private int? almacenId;
        private string nombre;
        private bool? almacenCentral;

        public AlmacenesDTO()
        {
            this.AlmacenId = null;
            this.Nombre = null;
            this.AlmacenCentral = null;
        }
        public AlmacenesDTO(int almacenId, string nombre, bool almacenCentral)
        {
            this.AlmacenId = almacenId;
            this.Nombre = nombre;
            this.AlmacenCentral = almacenCentral;
        }

        public int? AlmacenId { get => almacenId; set => almacenId = value; }
        public string Nombre { get => nombre; set => nombre = value; }
        public bool? AlmacenCentral { get => almacenCentral; set => almacenCentral = value; }
    }
}
