/**
 * Copyright 2010 CosmoCode GmbH
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package de.cosmocode.commons.reflect;

import com.google.common.base.Function;

import de.cosmocode.collections.tree.DefaultTree;
import de.cosmocode.collections.tree.TraverseMode;
import de.cosmocode.collections.tree.Tree;
import de.cosmocode.collections.tree.TreeNode;

/**
 * Implementation of {@link Reflection#getAllInterfaces()}.
 *
 * @since 1.11
 * @author Willi Schoenborn
 */
public enum GetAllSuperTypes implements Function<Class<?>, Iterable<Class<?>>> {

    INSTANCE;
    
    @Override
    public Iterable<Class<?>> apply(Class<?> type) {
        final TreeNode<Class<?>> root = new HierarchyTreeNode(type);
        final Tree<Class<?>> tree = new DefaultTree<Class<?>>(root);
        return tree.traverse(TraverseMode.LEVEL_ORDER);
    }

}