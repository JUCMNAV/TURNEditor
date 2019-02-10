package mcgill.xtext.turn.diagram.test

import com.google.inject.Guice
import com.google.inject.Injector
import mcgill.xtext.turn.TURNRuntimeModule
import mcgill.xtext.turn.diagram.TURNDiagramGenerator
import mcgill.xtext.turn.diagram.TURNDiagramModule
import mcgill.xtext.turn.ide.TURNIdeModule
import mcgill.xtext.turn.ide.TURNIdeSetup
import java.io.File
import java.util.Collection
import java.util.Set
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor
import org.eclipse.xtext.resource.IResourceDescriptions
import org.eclipse.xtext.resource.IResourceDescriptionsProvider
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.resource.XtextResourceSet
import org.eclipse.xtext.util.CancelIndicator
import org.eclipse.xtext.util.Modules2
import org.junit.Assert
import org.junit.BeforeClass
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import org.junit.runners.Parameterized.Parameters
import mcgill.xtext.turn.ide.TURNIdeSetup


@FinalFieldsConstructor
@RunWith(Parameterized)
class DiagramIntegrationTest {
	
	@Parameters(name= "{0}")
	static def Collection<Object[]> getFiles() {
		val params = newArrayList
		scanRecursively(new File("../mcgill.xtext.turn.ide/src/test/resources")) [
			val arr = <Object>newArrayOfSize(1)
			arr.set(0, it)
			params.add(arr)
		]
		return params
	}
	
	static Injector injector
	static IResourceDescriptions descriptions
	
	@BeforeClass
	static def void beforeClass() {
		injector = new TURNIdeSetup {
			override createInjector() {
				Guice.createInjector(Modules2.mixin(new TURNRuntimeModule, new TURNIdeModule, new TURNDiagramModule))
			}
		}.createInjectorAndDoEMFRegistration()

		val rs = injector.getInstance(XtextResourceSet)
		scanRecursively(new File("../mcgill.xtext.turn.ide/src/test/resources")) [
			rs.getResource(URI.createFileURI(absolutePath), true)
		]
		EcoreUtil.resolveAll(rs)
		descriptions = injector.getInstance(IResourceDescriptionsProvider).getResourceDescriptions(rs)
	}
	
	static def void scanRecursively(File file, (File)=>void acceptor) {
		if (file.isDirectory) {
			for (f : file.listFiles) {			
				scanRecursively(f, acceptor)
			}
		} else {
			if (file.name.endsWith('.turn')) {
				acceptor.apply(file)
			}
		}
	}

	val File file
	
	@Test def void testDiagram() {
		val resource = loadResources(URI.createFileURI(this.file.absolutePath))
		val generator = injector.getInstance(TURNDiagramGenerator)
		generator.generate(resource, new TestDiagramState(resource), CancelIndicator.NullImpl);
	}
	
	
	private def loadResources(URI uri) {
		val uris = newHashSet
		uri.addReferencedURIs(uris)
		val newRs = injector.getInstance(XtextResourceSet)
		uris.forEach [
			newRs.getResource(it, true)
		] 
		EcoreUtil.resolveAll(newRs)
		val xtextResource = newRs.getResource(uri, false) as XtextResource
		if (!xtextResource.errors.empty) {
			System.err.println(xtextResource.parseResult.rootNode.text)
			Assert.fail(xtextResource.errors.map[message].join('\n'))
		}

		return xtextResource
	}
	
	private def void addReferencedURIs(URI uri, Set<URI> uris) {
		if (uris.add(uri)) {
			descriptions.getResourceDescription(uri).referenceDescriptions.forEach [
				targetEObjectUri.trimFragment.addReferencedURIs(uris)
			]
		}
	}
}
