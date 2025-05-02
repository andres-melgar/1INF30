using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using SoftVenBusiness;

namespace SoftVenTest
{

    [TestClass]
    public class SoftVenBOTest
    {
        private ProductoBO productoBO;

        public SoftVenBOTest()
        {
            this.productoBO = new ProductoBO();
        }

        [TestMethod]
        public void TestInsertar()
        {
            Console.WriteLine("Insertar");
            int resultado = this.productoBO.Insertar("Mi nuevo producto", "Descripción nuevo prod", 122.22);
            Assert.IsTrue(resultado > 0);

            resultado = this.productoBO.Insertar("Mi nuevo producto2", "Descripción nuevo prod2", 322.22);
            Assert.IsTrue(resultado > 0);
        }
    }
}
